const passport = require("passport");
const local = require("./localStrategy");
const kakao = require("./kakaoStrategy");
const User = require("../models/user");

// PASSPORT는 전략을 사용한다
// 전략 -> 어떻게 로그인할건지?

module.exports = () => {
  passport.serializeUser((user, done) => {
    done(null, user.id); // 세션에 user의 Id만 저장
  });

  // 서버의 메모리 관리를 위해서(효율성)
  // 필요할 때마다 id값을 통해서 정보를 가져와준다.
  passport.deserializeUser((id, done) => {
    User.findOne({ where: { id } })
      .then((user) => done(null, user))
      .catch((err) => done(err));
  });

  local();
  kakao();
};
