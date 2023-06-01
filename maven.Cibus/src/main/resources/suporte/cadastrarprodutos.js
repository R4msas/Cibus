window.onload = function() {
      // Extrair parâmetros de consulta da URL
      const urlParams = new URLSearchParams(window.location.search);

      // Preencher campos do formulário com os valores correspondentes
      document.getElementById('produto-nome').value = urlParams.get('descricao');
      document.getElementById('produto-preco').value = urlParams.get('preco');
      document.getElementById('produto-tipo').value = urlParams.get('tipoProduto');
      document.getElementById('produto-supermercado').value = urlParams.get('codSupermercado');
      
    };



async function atualiza(id_oferta) {
	console.log(id_oferta);
	let preco = document.getElementById('produto-preco').value;
	let descricao = document.getElementById('produto-nome').value;
	let tipoProduto = document.getElementById('produto-tipo').value;
	let codSupermercado = document.getElementById('produto-supermercado').value;
	
  let url = `/update/?id_oferta=${id_oferta}&descricao=${descricao}&preco=${preco}&tipoProduto=${tipoProduto}&codSupermercado=${codSupermercado}`;

console.log(descricao + preco + tipoProduto + codSupermercado);
  await fetch(url, { method: "PUT" })
    .then(data => {
      console.log(data);
    })
  .then(data => {
	   
	  console.log(data);
	 
	   
	window.location.href = "produtos.html";	
})}

document.getElementById("atualiza-btn").addEventListener("click", atualiza(urlParams.get('id_oferta')));
