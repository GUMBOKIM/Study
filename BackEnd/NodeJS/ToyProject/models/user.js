const Sequelize = require("sequelize");

module.exports = class User extends Sequelize.Model {
  static init(sequelize) {
    return super.init(
      {
        account: {
          type: Sequelize.STRING(20),
          allowNull: false,
          unique: true,
        },
        nickname: {
          type: Sequelize.STRING(20),
          allowNull: false,
        },
        password: {
          type: Sequelize.STRING(20),
          allowNull: false,
        },
        role: {
          type: Sequelize.STRING(10),
          allowNull: false,
          defaultValue: "user",
        },
      },
      {
        sequelize,
        // createdAt, updatedAt 컬럼 추가
        timestamp: true,
        // 기본 -> Camel Case, underscored -> Snake Case
        underscored: false,
        // Node 프로젝트 내에서 사용되어지는 이름
        modelName: "User",
        // DB에 저장되는 테이블 이름
        tableName: "Users",
        // DeletedAt 컬럼 생성
        paranoid: false,
        charset: "utf8",
        collate: "utf8_general_ci",
      }
    );
  }
  static associate(db) {
      db.User.hasMany(db.Article, {
          foreignKey: 'writer',
          sourceKey: 'id'
      });
  }
};
