'use strict';

module.exports = (sequelize, DataTypes) => {
  const Wallet = sequelize.define('Wallet', {
    amount: DataTypes.DOUBLE,
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
  Wallet.associate = function(models) {
  	Wallet.belongsTo(models.User,{
  		foreignKey: 'userId'
  	})
    // associations can be defined here
  };
  return Wallet;
};