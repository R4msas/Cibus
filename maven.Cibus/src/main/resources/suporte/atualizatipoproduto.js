window.onload = function() {
      // Extrair parâmetros de consulta da URL
      const urlParams = new URLSearchParams(window.location.search);

      // Preencher campos do formulário com os valores correspondentes
      descricao=document.getElementById('produto-nome').value = urlParams.get('nome');
      document.getElementById('produto-id').value = urlParams.get('idProduto');  
    }