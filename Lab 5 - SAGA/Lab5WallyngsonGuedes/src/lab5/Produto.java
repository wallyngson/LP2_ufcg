package lab5;

public class Produto {

	private String nome;
	private String descricao;
	private float preco;

	public Produto(String nome, String descricao, float preco) {
		this.parametroErrado(nome, descricao, preco);
		
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Produto(String nomeProduto, String descricao) {
		this.nome = nomeProduto;
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public String getDesricao() {
		return this.descricao;
	}
	
	public String alteraPreco(float preco) {
		if (preco <= 0)
			return "Nao foi possivel modificar preco, preco nao pode ser negativo!";
		
		this.preco = preco;
		return "Preco alterado com sucesso!";
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.descricao + " - R$" + this.preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + Float.floatToIntBits(preco);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Produto novoProduto = (Produto) obj;
		return this.formataFrase(this.getNome()).equals(this.formataFrase(novoProduto.getNome())) 
				&& this.formataFrase(this.getDesricao()).equals(this.formataFrase(novoProduto.getDesricao()));
	}
	
	private String formataFrase(String frase) {
		return frase.toLowerCase().replace(" ", "");
	}
	
	
	private void parametroErrado(String nome, String descricao, float preco) {
		if (nome == null || descricao == null || preco <= 0)
			throw new NullPointerException();
		if (nome.equals("") || descricao.equals("") || preco <= 0)
			throw new IllegalArgumentException();
	}

}
