const passport = require('passport');
const local = require('./localStrategy');

const User = require('../models/user');

// PassPort 작동 순서
// 1. 라우터를 통해서 로그인 요청이 들어옴
// 2. 라우터에서 passport.authenticate 메서드 호출
// 3. 로그인 전략 수행
// 4. 로그인 성공 시 사용자 정보 객체오 함께 req.login 호출
// 5. req.login 메서드가 passport.serializeUser 호출
// 6. req.session에 사용자 아이디만 저장
// 7. 로그인 완료

module.exports = () => {
    // 로그인 시 실행
    // req.session 객체에 어떤 데이터를 저장할지 정하는 메서드
    // 여기선 user.id를 넘겨줌
    passport.serializeUser((user, done) => {
        done(null, user.id);
    });

    // 매 요청시 실행
    // user의 id를 통해서 사용자 정보를 조회한다.
        passport.deserializeUser((id, done) => {
        User.findOne({where : {
            id
        }})
        .then(user => done(null, user))
        .catch(err => done(err));
    });

    local();
}