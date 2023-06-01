function carrega() {
  let url = `/allSupermercado/`;
  fetch(url)
    .then(res => res.json())
    .then(data => {
      let str = '';

      for (let i = 0; i < data.length; i++) {
        let supermercado = data[i];

        str += `
          <tr>
            <td>${supermercado.nome}</td>
            <td>${supermercado.id_supermercado}</td>
            <td>${supermercado.site}</td>
            <td>
              <button onClick="excluir(${supermercado.id_supermercado})" class="excluir-btn">Excluir</button>
              <button onClick="redirecionarParaAtualizar(${supermercado.codSupermercado}, '${supermercado.nome}', '${supermercado.site}')" class="atualizar-btn">Atualizar</button>
            </td>
          </tr>
        `;
      }

      // Atualizar o conteúdo da tabela com as linhas geradas dinamicamente
      document.querySelector('#supermercados-table tbody').innerHTML = str;
    });
}

function redirecionarParaAtualizar(codSupermercado, nome, site) {
  // Codifique os valores para evitar problemas com caracteres especiais na URL
  const nomeCodificado = encodeURIComponent(nome);
  const siteCodificado = encodeURIComponent(site);

  // Construa a URL com os parâmetros de consulta
  const url = `atualizarsupermercado.html?codSupermercado=${codSupermercado}&nome=${nomeCodificado}&site=${siteCodificado}`;

  // Redirecione para a página de atualização com os parâmetros de consulta
  window.location.href = url;
}

carrega();

async function excluir(id) {
  let url = `/deleteSupermercado/?id_supermercado=${id}`;

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