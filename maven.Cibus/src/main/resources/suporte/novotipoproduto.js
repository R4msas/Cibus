async function inserir(){
	let nome = document.getElementById('tipo-produto-nome').value 
	let url = `/insertTipo/?nome=${nome}`
	await fetch(url, { method: "POST" })
    .then(data => {
      console.log(data);
    })

  .then(data => {
	  console.log(data);
	  
	  }
	)
	//location.reload();	
}



function carrega(){
  let url = `/allTipo/`;
  fetch(url)
    .then(res => res.json())
    .then(data => {
      let str = '';
      for (let i = 0; i < data.length; i++) {
        let tipoproduto = data[i];
        
        str += `
          <tr>
            <td>${tipoproduto.id}</td>
            <td>R$ ${tipoproduto.nome}</td>
            <td>
              <button onClick="excluir(${tipoproduto.id})" class="excluir-btn">Excluir</button>
              <button onClick="redirecionarParaAtualizar(${tipoproduto.id}, ${tipoproduto.nome})" class="atualizar-btn">Atualizar</button>
            </td>
          </tr>
        `;
      }

      // Atualizar o conteúdo da tabela com as linhas geradas dinamicamente
      document.querySelector('#tipos-produto-table tbody').innerHTML = str;
    });
}

function redirecionarParaAtualizar(id, nome) {
  // Codifique os valores para evitar problemas com caracteres especiais na URL
  const nomeCodificado = encodeURIComponent(nome);

  // Construa a URL com os parâmetros de consulta
  const url = `atualizatipoproduto.html?id=${id}&nome=${nomeCodificado}`;

  // Redirecione para a página de cadastro com os parâmetros de consulta
  window.location.href = url;
}
carrega();
		
		async function excluir(id) {
  let url = `/deleteTipo/?idProduto=${id}`;

  await fetch(url, { method: "DELETE" })
    .then(data => {
      console.log(data);
    })

  .then(data => {
	  console.log(data);
	  
	  }
	)
	location.reload();	
}
