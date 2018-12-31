'use strict';

module.exports = (sequelize, DataTypes) => {
  const Festival = sequelize.define('Festival', {
    name: DataTypes.STRING,
    price: DataTypes.DOUBLE,
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
  Festival.associate = function(models) {
    // associations can be defined here
  };
  return Festival;
};