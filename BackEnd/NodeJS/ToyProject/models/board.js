const Sequelize = require("sequelize");

module.exports = class Board extends Sequelize.Model {
  static init(sequelize) {
    return super.init(
      {
        boardname: {
          type: Sequelize.STRING(20),
          allowNull: false,
          unique: true,
        },
      },
      {
        sequelize,
        // timestamp => createdAt, updatedAt 컬럼 추가
        timestamp: false,
        // 기본 -> Camel Case, underscored -> Snake Case
        underscored: false,
        // Node 프로젝트 내에서 사용되어지는 이름
        modelName: "Board",
        // DB에 저장되는 테이블 이름
        tableName: "Boards",
        // DeletedAt 컬럼 생성
        paranoid: false,
        charset: "utf8",
        collate: "utf8_general_ci",
      }
    );
  }
  static associate(db) {
    db.Board.hasMany(db.Article, {
      foreignKey: "boardid",
      sourceKey: "id",
    });
  }
};
