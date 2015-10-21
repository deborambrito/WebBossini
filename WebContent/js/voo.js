$(function(){

	$(".btnfecharmodal").click(function(){
		
	});
	
	$('#filter').keyup(function () {

        var rex = new RegExp($(this).val(), 'i');
        $('.tabelaVoos tr').hide();
        $('.tabelaVoos tr').filter(function () {
            return rex.test($(this).text());
        }).show();

    });
    
	$(".btn-alterarvoo").click(function(){
		
		var idvoo = $(this).attr("data-idvoo");
		
		InformacaoVoo(idvoo);
		
	});
	
	$(".btn-excluirvoo").click(function(){

		var idvoo = $(this).attr("data-idvoo");
		$(".btn-excluirvoomodal").attr("data-idvoomodal",idvoo);

	});

	$(".btn-excluirvoomodal").click(function(){

		var id = $(this).attr("data-idvoomodal");

		ExcluirVoo(id);
	});
})

function InformacaoVoo(id)
{
	var data = "idvoo=" + id;
	
	$.ajax({
		data: data,
		dataType: 'json',
		url: '../vooalterar.do',
		type: 'GET',
		beforeSend: function(){
			$(".loader").show();
		},
		success: function(json){
			var comSelect = "";
			var aeroSelect = "";
			
			$(json.Companhia).each(function(){
				comSelect += "<option value=\""+this.id+"\">"+this.nome+"</option>";
			});
			
			$(json.Aeroporto).each(function(){
				aeroSelect += "<option value=\""+this.IdAeroporto+"\">"+this.Nome+"</option>";
			});
			
			$(".origemVooModal").html(aeroSelect);
			$(".chegadaVooModal").html(aeroSelect);
			$(".companhiaVooModal").html(comSelect);
			
			$(json.Select).each(function(){
				
				var dtOrigem = this.DataOrigemFormat.split("/")[2]+"-"+this.DataOrigemFormat.split("/")[1]+"-"+this.DataOrigemFormat.split("/")[0];
				var dtDestino = this.DataDestinoFormat.split("/")[2]+"-"+this.DataDestinoFormat.split("/")[1]+"-"+this.DataDestinoFormat.split("/")[0];
				
				$(".origemVooModal").html(aeroSelect);
				$(".chegadaVooModal").html(aeroSelect);
				$(".companhiaVooModal").html(comSelect);
				$(".origemVooModal").val(this.IdOrigem);
				$(".chegadaVooModal").val(this.IdDestino);
				$(".companhiaVooModal").val(this.IdCompanhia);
				$(".horaChegadaVooModal").val(this.HoraDestino);
				$(".dataChegadaVooModal").val(dtDestino);
				$(".horaOrigemVooModal").val(this.HoraOrigem);
				$(".dataOrigemVooModal").val(dtOrigem);
				$(".input-idvoo").val(this.IdVoo);
			});
			
			
		},
		complete: function(){
			$(".loader").hide();
		}
	});
}

function ExcluirVoo(id)
{
	var data = "idvoo=" + id;

	$.ajax({
		data: data,
		dataType: 'json',
		url: '../vooexcluir.do',
		type: 'GET',
		success: function(json){
			var allVoos = "";

			$(json).each(function(){
				$(this.Voos).each(function(){
					
					allVoos += "<tr>"+
					"<td>"+this.IdVoo+"</td>"+
					"<td>"+this.Companhia+"</td>"+
					"<td>"+this.Origem+"</td>"+
					"<td>"+this.DataOrigemFormat+" - "+this.HoraOrigem+"</td>"+
					"<td>"+this.Destino+"</td>"+
					"<td>"+this.DataDestinoFormat+" - "+this.HoraDestino+"</td>"+
					"<td>"+
					"<button type=\"button\" class=\"btn btn-info btn-sm\" data-toggle=\"modal\" data-target=\"#AlterarModal\">"+
					"<span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\">"+
					"</span>"+
					"</button>"+
					"</td>"+
					"<td>"+
					"<button type=\"button\" class=\"btn btn-danger btn-sm btn-excluirvoo\" data-toggle=\"modal\" data-idvoo="+this.IdVoo+" data-target=\"#ExcluirModal\">"+
					"<span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\">"+
					"</span>"+
					"</button>"+
					"</td>"+
					"</tr>";

				});

			});

			$('#ExcluirModal').modal('hide');
			$(".tabelaVoos").html(allVoos);
		},
		error: function() {
			alert('Ajax readyState: '+xhr.readyState+'\nstatus: '+xhr.status + ' ' + err);
		}
	});

}