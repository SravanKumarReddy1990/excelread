

var gridlayer=new ol.layer.Vector({
      title: 'TN PARLIAMENT',
      source: new ol.source.Vector({
         format: new ol.format.GeoJSON(),
         url: 'tnparliament.geojson'
      })
  });

var map = new ol.Map({
    target: 'map',
    layers: [
    new ol.layer.Tile({
      source: new ol.source.OSM()
    }),gridlayer
    ],
    view: new ol.View({
        center: ol.proj.transform([78.38745117187499,11.86466302072273], 'EPSG:4326', 'EPSG:3857'),
        zoom: 10
    })
});

map.on('click', function(evt) {
var lonlat = ol.proj.transform(evt.coordinate, 'EPSG:3857', 'EPSG:4326');
  var lon = lonlat[0];
  var lat = lonlat[1];

		
});
 WebSocketTest()
    function WebSocketTest() {
            
            if ("WebSocket" in window) {
              // alert("WebSocket is supported by your Browser!");
               
               // Let us open a web socket
               var ws = new WebSocket("ws://part1290.herokuapp.com/chat/all");
				
               ws.onopen = function() {
                  console.log("Connected")
                  // Web Socket is connected, send data using send()
                  ws.send('{"from":"all","to":"sravan","content":"sdmv n","status":"jsn vjsd","contentType":"usermsg"}');
                  //alert("Message is sent...");
               };
				
               ws.onmessage = function (evt) {
                  var received_msg = evt.data;
	var received_msg_json=JSON.parse(received_msg.content);
	console.log("received from server : "+JSON.stringify(received_msg_json));
                  //alert("Message is received..."+received_msg_json.auth);

if(received_msg.contentType=="loc"){
var contents=received_msg.content;
var con[]=contents.spilt(",");
var centerLongitudeLatitude = ol.proj.fromLonLat([con[0], con[1]]);
var layer = new ol.layer.Vector({
  source: new ol.source.Vector({
    projection: 'EPSG:4326',
    features: [new ol.Feature(new ol.geom.Circle(centerLongitudeLatitude, 40))]
  }),
  style: [
    new ol.style.Style({
      stroke: new ol.style.Stroke({
        color: 'blue',
        width: 3
      }),
      fill: new ol.style.Fill({
        color: 'rgba(0, 0, 255, 0.1)'
      })
    })
  ]
});
map.addLayer(layer);
}

               };
				
               ws.onclose = function() { 
                  
                  // websocket is closed.
                  //alert("Connection is closed..."); 
               };
            } else {
              
               // The browser doesn't support WebSocket
               alert("WebSocket NOT supported by your Browser!");
            }
         }
function checData(){
 //var point= new ol.geom.Point(ol.proj.transform(, 'EPSG:4326', 'EPSG:3857'))
//var input=layerWFS.getSource().getFeaturesAtCoordinate(point);

var coord = ol.proj.fromLonLat([77.519105,10.248160]);
var features=tamilWFS.getSource().getFeatures();	
features.forEach(function(feature){ 
var polygon_extent=feature.getGeometry().getExtent();
var att = feature.getProperties();
  var contains = ol.extent.containsCoordinate(polygon_extent, coord);
  console.info(contains+" , "+att.ac_name);
if(contains==true){
console.log(feature.getGeometry());
}

});
}
