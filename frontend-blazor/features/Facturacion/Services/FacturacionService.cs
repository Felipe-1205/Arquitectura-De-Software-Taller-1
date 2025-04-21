/*using Microsoft.AspNetCore.SignalR.Client;

public class FacturaService
{
    private HubConnection _hubConnection;

    public event Action<Factura>? OnFacturaRecibida;

    public async Task ConectarAsync()
    {
        _hubConnection = new HubConnectionBuilder()
            .WithUrl("http://localhost:8090/facturahub") // Reemplaza con tu URL real
            .WithAutomaticReconnect()
            .Build();

        _hubConnection.On<Factura>("NuevaFactura", (factura) =>
        {
            OnFacturaRecibida?.Invoke(factura);
        });

        await _hubConnection.StartAsync();
    }

    public bool EstaConectado => _hubConnection?.State == HubConnectionState.Connected;
}
*/
