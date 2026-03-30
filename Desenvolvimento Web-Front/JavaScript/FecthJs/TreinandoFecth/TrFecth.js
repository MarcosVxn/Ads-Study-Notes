fetch("https://viacep.com.br/ws/01001000/json/")
.then(requisiçãoAPI => {
    if(!requisiçãoAPI.ok){
        throw new Error ("Erro na requisição");

    }
    // .json é um metodo e no codigo abaixo só esta falando que quer em formato json
    // esse return vai mandar os dados para o proximo then
    return requisiçãoAPI.json();
})
.then(lerRequisição =>{
    console.log(lerRequisição.logradouro);
    console.log(lerRequisição.localidade);
    console.log(lerRequisição.uf);
})
.catch(erro => {
    console.log("Erro:", erro.message);
});