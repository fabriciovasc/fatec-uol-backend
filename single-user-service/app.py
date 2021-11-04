from flask import Flask

from app.models import SingletonModel

app = Flask(__name__)

def create_app():
    return app