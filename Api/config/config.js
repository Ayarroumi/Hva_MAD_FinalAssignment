
const path = require("path")
const databasePath  = path.join(__dirname,"../festival.db")

module.exports = {
  "development": {
    "username": "root",
    "password": "rootroot",
    "database": "festivalDB",
    "host": '127.0.0.1',
    "dialect": "mysql",
    "storage": databasePath
  },
  "test": {
    "username": null,
    "password": null,
    "database": "mydb",
    "dialect": "sqlite",
    "storage": databasePath
  },
  "production": {
    "username": null,
    "password": null,
    "database": "mydb",
    "dialect": "sqlite",
    "storage": databasePath
  }
}