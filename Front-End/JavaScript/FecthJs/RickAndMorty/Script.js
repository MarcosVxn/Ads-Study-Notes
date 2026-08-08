// pega um elemento do HTML pelo id pra eu poder usar ele no JS
const characterId = document.getElementById('characterId');
const btnGo = document.getElementById('btn-go');
const content = document.getElementById('content');
const image = document.getElementById('Img');

// o fecthApi tem a função que vai fazer a requisição para a API usando o valor informado
const fetchApi = (value) => {
    const result = fetch(`https://rickandmortyapi.com/api/character/${value}`) // ${value} coloca o número digitado pelo usuário na URL para buscar o personagem
    .then((res) => res.json())
    .then((data) => {
        console.log(data);
        return data;
    });

    return result;
}

fetchApi(1);
// o asyc quer dizer que é uma função assicrona que não acontece em tempo real ela vai esperar a promise
// função assíncrona que permite usar await para esperar a resposta da API
btnGo.addEventListener('click', async (event) => { 
    event.preventDefault();
    // await espera a Promise resolver e retorna o resultado
    const result = await fetchApi(characterId.value);
    // transforma o objeto em texto formatado para exibir na tela
    content.textContent = `${JSON.stringify(result, undefined, 2)}`;
    // define a imagem do personagem usando a URL retornada da API
    image.src = `${result.image}`;
});