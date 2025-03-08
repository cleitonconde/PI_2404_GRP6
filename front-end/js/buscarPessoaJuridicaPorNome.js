async function buscarPessoaJuridicaPorNome() {
    const nome = prompt("Digite o nome da Pessoa Juridica:");
    if (!nome) return;
    const nomeCodificado = encodeURIComponent(nome);
    try {
        const response = await fetch(`http://localhost:8080/api/pessoas-juridicas/buscar?nome=${nomeCodificado}`);
        if (!response.ok) {
            throw new Error("Erro ao buscar pessoas");
        }
        //console.log("Resposta da API:", response.text()); // Log para debug
        const pessoas = await response.json();

        if (pessoas.length === 0) {
            alert("Nenhuma pessoa encontrada.");
            return;
        }

        // Exibir o modal e preencher a lista
        const modal = document.getElementById("modalPessoa");
        const lista = document.getElementById("listaPessoas");

        lista.innerHTML = ""; // Limpar lista anterior
        pessoas.forEach((pessoa) => {
            const li = document.createElement("li");
            li.textContent = pessoa.nome;
            li.onclick = () => selecionarPessoa(pessoa);
            lista.appendChild(li);
        });

        modal.style.display = "flex"; // Exibir modal
    } catch (error) {
        console.error("Erro ao buscar pessoas:", error);
        alert("Erro ao buscar pessoas.");
    }
}

function selecionarPessoa(pessoa) {
    console.log('Texto a ser exibido no console');
    console.log('pessoa', pessoa.display);
    document.getElementById("nome").value = pessoa.nome;
    document.getElementById("razaoSocial").value = pessoa.razaoSocial;
    document.getElementById("cnpj").value = pessoa.cnpj;
    document.getElementById("inscricaoEstadual").value = pessoa.inscricaoEstadual;
    fecharModal();
}

function fecharModal() {
    document.getElementById("modalPessoa").style.display = "none";
}



