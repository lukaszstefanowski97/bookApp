import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import {Button, Col} from "reactstrap";


class App extends Component {

    state = {};

    componentDidMount() {
        setInterval(this.hello, 250);
    }

    hello = () => {
        fetch('/hello')
            .then(response => response.text())
            .then(message => {
                this.setState({message: message});
            });
    };

    render() {
        return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <h1 className="App-title">{this.state.message}</h1>
            </header>
            <Col className="App-row">
                <Button style={{width: "300px", height: "100px"}}>
                    List of books
                </Button>
                <Button style={{width: "300px", height: "100px"}}>
                    Add book
                </Button>
            </Col>
        </div>
        );
    }
}

export default App;