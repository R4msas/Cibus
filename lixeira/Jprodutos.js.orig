function carrega() {
  var categoria = {
    "1": "Carne",
    "2": "Bebidas alcoólicas",
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
        let supermercado;

        // Verificar o código do supermercado e definir o nome
        if (oferta.codSupermercado == 1) {
          supermercado = "Supermercados BH";
        } else if (oferta.codSupermercado == 2) {
          supermercado = "EPA Supermercados";
        } else {
          supermercado = oferta.codSupermercado;
        }

        str += `
          <tr>
            <td>${oferta.descricao}</td>
            <td>R$ ${oferta.preco}</td>
            <td>${cate}</td>
            <td>${supermercado}</td>
            <td>
              <button onClick="excluir(${oferta.id_oferta})" class="excluir-btn">Excluir</button>
              <button onClick="redirecionarParaAtualizar(${oferta.id_oferta}, '${oferta.descricao}', ${oferta.preco}, ${oferta.tipoProduto}, ${oferta.codSupermercado})" class="atualizar-btn">Atualizar</button>
            </td>
          </tr>
        `;
      }

      // Atualizar o conteúdo da tabela com as linhas geradas dinamicamente
      document.querySelector('#produtos-table tbody').innerHTML = str;
    });
}

function redirecionarParaAtualizar(id_oferta, descricao, preco, tipoProduto, codSupermercado) {
  // Codifique os valores para evitar problemas com caracteres especiais na URL
  const descricaoCodificada = encodeURIComponent(descricao);

  // Construa a URL com os parâmetros de consulta
  const url = `cadastrarprodutos.html?id_oferta=${id_oferta}&descricao=${descricaoCodificada}&preco=${preco}&tipoProduto=${tipoProduto}&codSupermercado=${codSupermercado}`;

  // Redirecione para a página de cadastro com os parâmetros de consulta
  window.location.href = url;
}

carrega();


//=======================================================FETCHs
//EXCLUIR:
<<<<<<< HEAD

=======
>>>>>>> 331c3ce59edec40752e566a8fff3cb51a41d36a0
async function excluir(id) {
  let url = `/delete/?id=${id}`;

  await fetch(url, { method: "DELETE" })
    .then(data => {
      console.log(data);
    })
<<<<<<< HEAD

=======
>>>>>>> 331c3ce59edec40752e566a8fff3cb51a41d36a0
  .then(data => {
	  console.log(data);
	  
	  
	  }
	)
	location.reload();	
}


async function excluirSupermercado(idSupermercado){
	let url = `/deleteSupermercado/?id_supermercado=${idSupermercado}`;

	await fetch(url, {method:"DELETE"})

  .then(data => {
	  console.log(data);
	  
	  
	  }
	)
	location.reload();	
}

<<<<<<< HEAD:maven.Cibus/src/main/resources/public/Jprodutos.js
=======
//INSERIR
<<<<<<< HEAD
  location.reload();
}
=======
>>>>>>> f4c6ac42f94799ddf7ff152a16320dc2d928af3e:maven.Cibus/src/main/resources/public/produtos.js


>>>>>>> 331c3ce59edec40752e566a8fff3cb51a41d36a0
