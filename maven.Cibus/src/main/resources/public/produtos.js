function carrega() {
  var categoria = {
    "1": "Carne",
    "2": "Bebidas",
    "3": "Arroz",
    "4": "Feijão",
    "5": "Óleos",
    "6": "Macarrão",
    "7": "Suco",
    "8": "Refrigerante",
    "9": "Bolacha",
    "10": "Pão",
    "11": "Laticínios",
    "12": "Shampoo",
    "13": "Sabonete",
    "14": "Sabão",
    "15": "Cerveja",
    "16": "Farinha",
    "17": "Café",
    "18": "Iogurtes",
    "19": "Leite"
  };

  let url = `/all`;
fetch(url)
  .then(res => res.json())
  .then(data => {
    let str = '';
    console.log(data);

    for (let i = 0; i < data.length; i++) {
      let oferta = data[i];
      let cate = categoria[oferta.tipoProduto];

      str += `
        <tr>
          <td>${oferta.descricao}</td>
          <td>R$ ${oferta.preco}</td>
          <td>${cate}</td>
          <td>
            <button class="excluir-btn">Excluir</button>
          </td>
        </tr>
      `;
    }

    // Atualizar o conteúdo da tabela com as linhas geradas dinamicamente
    document.querySelector('#produtos-table tbody').innerHTML = str;
  });

}

carrega();
