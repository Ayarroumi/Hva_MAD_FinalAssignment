'use strict';

module.exports = (sequelize, DataTypes) => {
  const User = sequelize.define('User', {
    username: DataTypes.STRING,
    password: DataTypes.STRING,
    createdAt: {
    	type: DataTypes.DATE,
    	defaultValue: DataTypes.NOW,
    	allowNull: false
    },
    updatedAt: {
    	type: DataTypes.DATE,
    	allowNull: true
    }
  }, {});
  User.associate = function(models) {
    // associations can be defined here
  };
  return User;
};