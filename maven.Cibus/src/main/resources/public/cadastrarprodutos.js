window.onload = function() {
      // Extrair parâmetros de consulta da URL
      const urlParams = new URLSearchParams(window.location.search);

      // Preencher campos do formulário com os valores correspondentes
      document.getElementById('produto-nome').value = urlParams.get('descricao');
      document.getElementById('produto-preco').value = urlParams.get('preco');
      document.getElementById('produto-tipo').value = urlParams.get('tipoProduto');
      document.getElementById('produto-supermercado').value = urlParams.get('codSupermercado');
    };

  