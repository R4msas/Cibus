window.onload = function() {
      // Extrair parâmetros de consulta da URL
      const urlParams = new URLSearchParams(window.location.search);

      // Preencher campos do formulário com os valores correspondentes
      document.getElementById('produto-nome').value = urlParams.get('nome');
      document.getElementById('produto-id').value = urlParams.get('id');  
    }
    
    document.getElementById("atualiza-btn").addEventListener("click",async function atualiza(){

  console.log("chamou a requisição")
  urlParams=new URLSearchParams(window.location.search);
  let id=urlParams.get('id');
	let descricao = document.getElementById('produto-nome').value;
	
  let url = `/updateTipo/?idProduto=${id}&nome=${descricao}`;

  await fetch(url, { method: "PUT" })
    .then(data => {
      console.log(data);
    })
  .then(data => {
	   
	  console.log(data);
	 
	
	window.location.href = "novotipoproduto.html";	
})})