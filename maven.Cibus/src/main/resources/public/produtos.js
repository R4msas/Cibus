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
      let supermercado;

       

        // Verificar o código do supermercado e definir o nome
        if (oferta.codSupermercado == 1) {
          supermercado = "Supermercados BH";
        } 
        else if(oferta.codSupermercado == 2){
			supermercado = "EPA Supermercados";
		}
		else {
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
             <button onClick="window.location.href='cadastrarprodutos.html'" class="atualizar-btn">Atualizar</button>
          </td>
        </tr>
      `;
    }

    // Atualizar o conteúdo da tabela com as linhas geradas dinamicamente
    document.querySelector('#produtos-table tbody').innerHTML = str;
  });

}

carrega();

//=======================================================FETCHs
//EXCLUIR:
async function excluir(id){
	let url = `/delete/?id=${id}`;

	await fetch(url, {method:"DELETE"})

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

//INSERIR
