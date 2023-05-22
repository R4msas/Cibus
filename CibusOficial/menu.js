const content = document.querySelector(".content");
const inputSearch = document.querySelector("input[type='search']");

let items = [];

function addHTML(item){
    const div = document.createElement("div");
    div.innerHTML = item;
    content.append(div);
}

fetch("")
.then((data) => data.json())
.then((produto) => {
    produto.forEach((produto) =>{
        addHTML(produto.nome);
        items.push(produto.nome);
    })
})