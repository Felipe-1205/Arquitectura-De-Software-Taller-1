using System.Net.Http.Json;

public class PedidoService
{
    private readonly HttpClient _http;

     public PedidoService(HttpClient http)
    {
        _http = http;
    }

    public async Task CrearPedido(Pedido pedido)
    {
        await _http.PostAsJsonAsync("http://localhost:8080/api/pedidos", pedido);
    }
}