'use strict';


module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.changeColumn(
      'Wallets',
      'createdAt',
      {
        type: Sequelize.DATE,
        defaultValue: Sequelize.fn('NOW')
      }
    );
  },

  down: (queryInterface, Sequelize) => {
    return queryInterface.changeColumn(
      'Wallets',
      'createdAt',
      {
        type: Sequelize.DATE,
        defaultValue: null
      }
    );
  }
};
