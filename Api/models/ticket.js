'use strict';

module.exports = (sequelize, DataTypes) => {
  const Ticket = sequelize.define('Ticket', {
    name: DataTypes.STRING,
    url: DataTypes.STRING,
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
  Ticket.associate = function(models) {
  	Ticket.hasOne(models.User,{
  		foreignKey: 'userId'
  	})

  	Ticket.hasOne(models.Festival,{
  		foreignKey: 'festivalId'
  	})
    // associations can be defined here
  };
  return Ticket;
};