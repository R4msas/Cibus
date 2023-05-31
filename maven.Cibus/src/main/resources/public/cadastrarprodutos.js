





async function atualizar(id){
	let url = `/update/?id=${id}&descricao=${descricao}&preco=${preco}&tipoProduto=${tipoProduto}&codSupermercado=${codSupermercado}`;

	await fetch(url, {method:"PUT"});

}