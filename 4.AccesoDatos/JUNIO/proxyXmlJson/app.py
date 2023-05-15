from flask import Flask
from flask import request
from flask_cors import CORS
import requests
import xmltodict

app = Flask(__name__)
cors = CORS(app, resources={"/proxy": {"origins":"*"}})

@app.route("/")
def hola_mundo():
    return "<p>Hola Mundo</p>", 200
# 
# En el POST le mandamos una variable
# url = https://www.elperiodico.com/es/rss/rss_portada.xml
@app.post("/proxy")
def proxy():
    url = request.args['url']
    if (url.startswith("https://")):
        data = requests.get(url)
        respuesta = xmltodict.parse(data.content)
        return respuesta, 200
    else:
        return "<p>Error handling URL</p>", 400
