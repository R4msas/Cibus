function inserir(){
	let url = `/insertTipo`
	fetch(url)
}



function carrega() {
  let url = `/allTipo`;
  fetch(url)
    .then(res => res.json())
    .then(data => {
      let str = '';
      for (let i = 0; i < data.length; i++) {
        let tipoproduto = data[i];
        
        str += `
          <tr>
            <td>${tipoproduto.idProduto}</td>
            <td>R$ ${tipoproduto.nome}</td>
            <td>
              <button onClick="excluir(${tipoproduto.idProduto})" class="excluir-btn">Excluir</button>
              <button onClick="redirecionarParaAtualizar(${tipoproduto.idProduto}, ${tipoproduto.nome})" class="atualizar-btn">Atualizar</button>
            </td>
          </tr>
        `;
      }

      // Atualizar o conteúdo da tabela com as linhas geradas dinamicamente
      document.querySelector('#tipos-produto-table tbody').innerHTML = str;
    });
}

function redirecionarParaAtualizar(idProduto, nome) {
  // Codifique os valores para evitar problemas com caracteres especiais na URL
  const nomeCodificado = encodeURIComponent(nome);

  // Construa a URL com os parâmetros de consulta
  const url = `atualizatipoproduto.html?idProduto=${idProduto}&nome=${nomeCodificado}`;

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
