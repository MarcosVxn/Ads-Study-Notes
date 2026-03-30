/** Promise

const minhaPromise = new Promise((resolve, reject) => {
    if (false) {
        resolve("Deu tudo certo!")
    } else {
        reject("Algo deu errado!")
    }
});

minhaPromise
    .then(mensagemSucesso => {
        console.log(mensagemSucesso);
    })
    .catch(erro => {
        console.log(erro);
    })
**/
// FECTH -> Fazer requisição a algum sistema pegando ou mandando informações

// Pegar dados é uma requisição GET

// Enviar dados é uma requisição POST

fetch("https://viacep.com.br/ws/01001000/json/")
// then é usado quando a requisição foi feita com sucesso.
.then(mensagemSucesso=>{
    // mensagemSucesso é minha variavel objeto que vou usar para resposta da requisição 
    // esse If vai verificar se deu algum erro no status do servidor usando o ok que iria verificar se deu tudo certo mas usando o ! ele vai verificar se foi diferente
    if(!mensagemSucesso.ok){
        // o throw é usado para criar um novo erro então se ele for executado ele vai ser direto direcionado para o catch
        throw new Error("Erro na requisição: " + mensagemSucesso.status);
    }
   return mensagemSucesso.json();
   // o return vai pegar o valor da mensagemSucesso e mandar para o meu proximo then
})
.then(dado => {
    console.log(dado);
})
// catch é usado quando a requisição não foi concluida
.catch(erro => {
    console.log(erro.message);
})

// Tratamento de erro

// Erro de requisição com servidor - > Catch, resultado da promise

// Erro de status de servidor - >

// .ok -> Verifica se uma requisição foi feita com sucesso, true or false



/** OBJETO

// objeto é um conjunto de dados organizados em chave e valor

const pessoa = {
  nome: "Marcos",
  idade: 18
};

// acessando
console.log(pessoa.nome);

**/