'use strict';

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.changeColumn(
      'Transactions',
      'createdAt',
      {
        type: Sequelize.DATE,
        defaultValue: Sequelize.fn('NOW')
      }
    );
  },

  down: (queryInterface, Sequelize) => {
    return queryInterface.changeColumn(
      'Transactions',
      'createdAt',
      {
        type: Sequelize.DATE,
        defaultValue: null
      }
    );
  }
};
