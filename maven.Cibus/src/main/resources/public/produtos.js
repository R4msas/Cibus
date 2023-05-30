function carrega() {
	var categoria = {
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
       
        str += `
          <table>
      <tr>
        <th>${oferta.descricao}</th>
        <th>${oferta.preco}</th>
        <th>${}</th>
        <th>Ações</th>
      </tr>
      <tr>
        <td>Produto 1</td>
        <td>R$ 10.00</td>
        <td>Categoria 1</td>
        <td>
          <button class="excluir-btn">Excluir</button>
        </td>
      </tr>
      <tr>
        <td>Produto 2</td>
        <td>R$ 15.00</td>
        <td>Categoria 2</td>
        <td>
          <button class="excluir-btn">Excluir</button>
        </td>
      </tr>
    </table>
        `;
      }

      // Colocar todos os cards dentro do contêiner
      document.getElementById('tela').innerHTML = `
        <div class="produtos-container">
          ${str}
        </div>
      `;
    });
}