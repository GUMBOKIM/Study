const Sequelize = require('sequelize');
const User = require('./user');
const Article = require('./article');
const Board = require('./board');

const env = process.env.NODE_ENV || 'development';
const config = require('../config/config.json')[env];
const db = [];

const sequelize = new Sequelize(config.database, config.username, config.password, config);
db.sequelize = sequelize;

db.User = User;
db.Article = Article;
db.Board = Board;

User.init(sequelize);
Article.init(sequelize);
Board.init(sequelize);

User.associate(db);
Article.associate(db);
Board.associate(db);

module.exports = db;