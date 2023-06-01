function carrega() {
  var tipoProdutoImagem = {
    "1": "images/carneCibus.jpeg",
    "2": "images/bebeidasCibus.jpeg",
    "3": "images/arrozCibus.jpeg",
    "4": "images/feijãoCibus.jpeg",
    "5": "images/oleosCibus.jpeg",
    "6": "images/macarraoCibus.jpeg",
    "7": "images/sucosCibus.jpeg",
    "8": "images/refrisCibus.jpeg",
    "9": "images/bolachasCibus.jpeg",
    "10": "images/paesCibus.jpeg",
    "11": "images/laticiniosCibus.jpeg",
    "12": "images/xampusCibus.jpeg",
    "13": "images/sabaoCibus.jpg",
    "14": "images/sabaoCibus.jpg",
    "15": "images/cervejaCibus.jpeg",
    "16": "images/farinhaCibus.jpeg",
    "17": "images/cafeCibus.jpeg",
    "18": "images/iogurtesCibus.jpeg",
    "19": "images/leiteCibus.jpeg"
  };
  
  let url = `/all`;
  fetch(url)
    .then(res => res.json())
    .then(data => {
      let str = '';
      console.log(data);

      for (let i = 0; i < data.length; i++) {
        let oferta = data[i];
        let imagem = tipoProdutoImagem[oferta.tipoProduto] || "default.png";
        let supermercado;

       

        // Verificar o código do supermercado e definir o nome
        if (oferta.codSupermercado === 1) {
          supermercado = "Supermercados BH";
        } 
        
        else if(oferta.codSupermercado === 2){
			supermercado = "EPA Supermercados"
		}
		else{
			supermercado = oferta.codSupermercado
		}

        str += `
          <div class="card">
            <img src="${imagem}" alt="Imagem do Produto" class="product-image">
            <h1 class="product-name">${oferta.descricao}</h1>
            <p class="product-price">R$ ${oferta.preco}</p>
            <h2 class="product-supermercado">${supermercado}</h2>
          </div>
        `;
      }

      document.getElementById('tela').innerHTML = `
        <div class="card-container">
          ${str}
        </div>
      `;
    });
}

carrega();

// Obtenha a referência para a barra de pesquisa
const searchInput = document.getElementById('search-input');

// Adicione um ouvinte de evento 'input' à barra de pesquisa
searchInput.addEventListener('input', function() {
  const searchTerm = searchInput.value.toLowerCase();

  // Obtenha todos os cards
  const cards = document.getElementsByClassName('card');

  // Itere sobre os cards e aplique o filtro
  for (let i = 0; i < cards.length; i++) {
    const card = cards[i];
    const cardName = card.querySelector('.product-name').textContent.toLowerCase();

    if (cardName.includes(searchTerm)) {
      card.style.display = 'block'; // Exiba o card se corresponder ao termo de pesquisa
    } else {
      card.style.display = 'none'; // Oculte o card se não corresponder ao termo de pesquisa
    }
  }
});
