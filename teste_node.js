var  Mongoose  = require('mongoose');

var palavraSchema = new Mongoose.Schema(
    {
        nome: { type: String },
        valores: Object
    });

var http      = require('http');

function onRequest(request, response){
    console.log("Requisição recebida");
    response.writeHead(200, {"Content-Type": "text;plain"});

    pesquisaPalavra(function(data){
        
        if (data != "") {
          response.write(data);    
        };
       
	   response.end();        
    });
          
 };

http.createServer(onRequest).listen(1337, '127.0.0.1');
console.log("Node.js foi iniciado");
Mongoose.connect('mongodb://localhost/pesquisa'); 

function pesquisaPalavra(callback){
    
    var pesqPalavra = Mongoose.model('palavras', palavraSchema);
    var db          = Mongoose.connection;
    var retorno_r   = "";

    db.on('error', console.error);

    db.once('open', function() {
        console.log('Conectado ao MongoDB.');
    });
 
    var arrayPalavras = new Array();
    arrayPalavras.push("nome: dedo");
    // arrayPalavras.push("nome: quebrei");

    // pesqPalavra.findOne({ nome: 'dedo' },'valores', function(err, palRetorno) {   
    pesqPalavra.find( {$or:[arrayPalavras]},'valores', function(err, palRetorno) {   
         if (err) return console.error(err);   
         retorno_r = JSON.stringify(palRetorno);
         console.log(retorno_r);
         callback(retorno_r);
    });
}
