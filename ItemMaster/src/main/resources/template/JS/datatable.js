async function getData(){
    const records = await fetch('http://localhost:8001/all');
    const data = records.json();

    let tab = '';
    data.items.forEach(function(item){
    tab += '<tr>
            <td>${item.storeId}</td>
            <td>${item.sku}</td>
            <td>${item.productName}</td>
            <td>${item.price}</td>
            <td>${item.date}</td>
            </tr>'
    })
    document.getElementById('tbody').innerHTML = tab;


    $('#itemTable').DataTable({
        "data" :"data.items",
        "columns" : [
        {"data" :"storeId"},
        {"data" :"sku"},
        {"data" :"productName"},
        {"data" :"price"},
        {"data" :"date"},
        ]})
}