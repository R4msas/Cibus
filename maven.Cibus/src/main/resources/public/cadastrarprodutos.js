window.onload = function() {
      // Extrair parâmetros de consulta da URL
      const urlParams = new URLSearchParams(window.location.search);

      // Preencher campos do formulário com os valores correspondentes
      document.getElementById('produto-nome').value = urlParams.get('descricao');
      document.getElementById('produto-preco').value = urlParams.get('preco');
      document.getElementById('produto-tipo').value = urlParams.get('tipoProduto');
      document.getElementById('produto-supermercado').value = urlParams.get('codSupermercado');
    };

async function atualiza(id_oferta,descricao,preco,tipoProduto,codSupermercado) {
  let url = `/update/?id_oferta=${id_oferta}&descricao=${descricao}&preco=${preco}&tipoProduto=${tipoProduto}&codSupermercado=${codSupermercado}`;

  await fetch(url, { method: "PUT" })
    .then(data => {
      console.log(data);
    })
  .then(data => {
	  console.log(data);
	  
	  
	  
	  
	  
	  
	  }
	)
	location.reload();	
}