'use strict';

module.exports = (sequelize, DataTypes) => {
  const Transaction = sequelize.define('Transaction', {
    productName: DataTypes.STRING,
    amount: DataTypes.INTEGER,
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
  Transaction.associate = function(models) {
    Transaction.hasOne(models.User,{
  		foreignKey: 'userId'
  	})

  	 Transaction.hasOne(models.Festival,{
  		foreignKey: 'festivalId'
  	})
  };
  return Transaction;
};