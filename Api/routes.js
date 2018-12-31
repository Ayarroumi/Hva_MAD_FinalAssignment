var express = require('express');
const bodyParser = require('body-parser');
const path = require('path')
var models = require(path.join(__dirname, './models/index'))

var app = express();
app.use(bodyParser.json());

app.post('/login', (req, res) => {
	var { User } = models
	var { username, password } = req.body

	User.findOne( {
		attributes: ['id','username'],
		where:{
			username: username,
			password: password
		}
	}).then((user) => {
		if(!user){
			throw new Error("Invalid credentials")
		}
		res.send(user.dataValues)
		
	}).catch((err) => {
		res.status(400)
		res.send({'error': err.message})
	})
})

app.get('/festivals', function(req, res){
  var { Festival } = models

  Festival.findAll({
  	attributes: ['id','name','price']
  }).then((festivals) => {
  	res.send({'festivals': festivals})
  })
});




app.get('/wallet', function(req, res){
	var { Wallet } = models
	const userId = req.query.userId

	Wallet.findOne({
		where:{
			userId: userId
		}
	}).then((wallet) => {
		if(!wallet){
			throw new Error("Invalid id")
		}
		res.send(wallet)
		
	}).catch((err) => {
		res.status(400)
		res.send({'error': err.message})
	})
});

app.patch('/wallet',(req, res) => {
	var { Wallet } = models
	const {id, amount, userId} = req.body
	console.log(id, amount, userId)
	console.log("req" + req.body)

	Wallet.findOne({
		where:{
			userId:userId
		}
	}).then((wallet) => {
		if(!wallet){
			throw new Error("Invalid id")
		}
		wallet.update({
			amount: amount
		}).then((wallet) => {
			res.send({wallet})
		})
	})


})


app.get('/transactions', function(req, res){
	var { Transaction } = models
	const userId = req.query.userId

	Transaction.findAll({
		attributes: ['id',['productName','product'],'amount','price','userId','festivalId',['createdAt','date']],
		where:{
			userId: userId
		}
	}).then((transactions) => {
		if(!transactions){
			throw new Error("Invalid id")
		}
		res.send({'transactions': transactions})
		
	}).catch((err) => {
		res.status(400)
		res.send({'error': err.message})
	})
});

app.get('/tickets', function(req, res){
	var { Ticket } = models
	const userId = req.query.userId

	if(userId){
		Ticket.findAll({
			attributes: ['id','name','url','userId','festivalId'],
			where:{
				userId: userId
			}
		}).then((tickets) => {
			if(!tickets){
				throw new Error("Invalid id")
			}
			res.send({'tickets': tickets})
			
		}).catch((err) => {
			res.status(400)
			res.send({'error': err.message})
		})
	}else{
		Ticket.findAll({
			attributes: ['id','name',['url','ticketUrl'],'userId','festivalId'],
		}).then((tickets) => {
			if(!tickets){
				throw new Error("Invalid id")
			}
			res.send({'tickets': tickets})
		}).catch((err) => {
			res.status(400)
			res.send({'error': err.message})
		})
	}

});




app.listen(3000);