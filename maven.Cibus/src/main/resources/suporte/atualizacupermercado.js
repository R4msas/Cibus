window.onload = function() {
  // Extrair parâmetros de consulta da URL
  const urlParams = new URLSearchParams(window.location.search);

  // Preencher campos do formulário com os valores correspondentes
  document.getElementById('supermercado-nome').value = urlParams.get('nome');
  document.getElementById('supermercado-link').value = urlParams.get('site');
  document.getElementById('supermercado-id').value = urlParams.get('id_supermercado');
}

document.getElementById("atualiza-btn").addEventListener("click", async function atualiza() {
  const urlParams = new URLSearchParams(window.location.search);
  
  let id = urlParams.get('id_supermercado');
  let descricao = document.getElementById('supermercado-nome').value;
  let site = document.getElementById('supermercado-link').value;
  
  let url = `/updateSupermercado/?id_supermercado=${id}&nome=${descricao}&site=${site}`;

  await fetch(url, { method: "PUT" })
    .then(data => {
      console.log(data);
      window.location.href = "cadastrosupermercado.html";
    });
});
