function carrega(){
    let requisicao= new XMLHttpRequest();
    requisicao.open("GET", `/all`);
    requisicao.send();

          let str = ''
          for (let i = 0; i < data.results.length; i++) {
            let oferta = data.results[i]
            str += `        <div class="card-body">
                            <h5 class="card-title">${oferta.descricao}</h5>
                            <p>Preço:${oferta.preco}</p>
                            <p>Supermercado ${oferta.supermercado}</p>
                          </div>`
          }
          document.getElementById('tela').innerHTML = str 
        }
