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