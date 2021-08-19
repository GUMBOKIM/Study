const Sequelize = require("sequelize");

module.exports = class Article extends Sequelize.Model {
  static init(sequelize) {
    return super.init(
      {
        title: {
          type: Sequelize.STRING(20),
          allowNull: false,
        },
        content: {
          type: Sequelize.STRING(200),
          allowNull: false,
        }
      },
      {
        sequelize,
        // createdAt, updatedAt 컬럼 추가
        timestamp: true,
        // 기본 -> Camel Case, underscored -> Snake Case
        underscored: false,
        // Node 프로젝트 내에서 사용되어지는 이름
        modelName: "Article",
        // DB에 저장되는 테이블 이름
        tableName: "Articles",
        // DeletedAt 컬럼 생성
        paranoid: false,
        charset: "utf8",
        collate: "utf8_general_ci",
      }
    );
  }
  static associate(db) {
      db.Article.belongsTo(db.User, {
          foreignKey: 'writer',
          targetKey: 'id',
      });
      db.Article.belongsTo(db.Board, {
        foreignKey: 'boardid',
        targetKey: 'id',
    });
  }
};
