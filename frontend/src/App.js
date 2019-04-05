/* eslint-disable */

import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';
import {Input, FormGroup, Label, Modal, ModalHeader, ModalBody, ModalFooter, Table, Col, Button} from 'reactstrap';
import Request from 'react-http-request';

class App extends Component {

    state = {
        books: [],
        newBookData: {
            author: '',
            title: '',
            isbn: ''
        },
        newBookModal: false,
        editBookModal: false
    };

    toggleNewBookModal() {
        this.setState({
            newBookModal: !this.state.newBookModal
        });
    }

    addBook() {
        axios.post('http://localhost:3000/api/addBook', this.state.newBookData).then((response) => {

            books.push(response.data);
            this.forceUpdate();

            this.setState({
                books, newBookModal: false, newBookData: {
                    author: '',
                    title: '',
                    isbn: ''
                }
            });
        });
    }

    componentDidMount() {
        setInterval(this.hello, 250);
    }

    render() {

        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h1 className="App-title">Welcome to bookApp!</h1>
                    <Col className="App-row">
                        <Button style={{width: "300px", height: "100px"}} onClick={this.toggleNewBookModal.bind(this)}>
                            Add book
                        </Button>
                    </Col>
                    <Modal isOpen={this.state.newBookModal} toggle={this.toggleNewBookModal.bind(this)}>
                        <ModalHeader toggle={this.toggleNewBookModal.bind(this)}>Add a new book</ModalHeader>
                        <ModalBody>
                            <FormGroup>
                                <Label for="author">Author</Label>
                                <Input id="author" value={this.state.newBookData.author} onChange={(e) => {
                                    let {newBookData} = this.state;

                                    newBookData.author = e.target.value;

                                    this.setState({newBookData});
                                }}/>
                            </FormGroup>
                            <FormGroup>
                                <Label for="title">Title</Label>
                                <Input id="title" value={this.state.newBookData.title} onChange={(e) => {
                                    let {newBookData} = this.state;

                                    newBookData.title = e.target.value;

                                    this.setState({newBookData});
                                }}/>
                            </FormGroup>
                            <FormGroup>
                                <Label for="isbn">ISBN</Label>
                                <Input id="isbn" value={this.state.newBookData.isbn} onChange={(e) => {
                                    let {newBookData} = this.state;

                                    newBookData.isbn = e.target.value;

                                    this.setState({newBookData});
                                }}/>
                            </FormGroup>

                        </ModalBody>
                        <ModalFooter>
                            <Button color="primary" onClick={this.addBook.bind(this)}>Add Book</Button>{' '}
                            <Button color="secondary" onClick={this.toggleNewBookModal.bind(this)}>Cancel</Button>
                        </ModalFooter>
                    </Modal>
                    <Table>
                        <thead>
                        <tc className={"App-body"}>
                            <th>Author
                                <Request
                                    url='/books/authors'
                                    method='get'
                                    accept='application/json'
                                    verbose={true}>
                                    {
                                        ({error, result, loading}) => {
                                            if (loading) {
                                                return <div>loading...</div>;
                                            } else {
                                                return <div>{JSON.stringify(result.body)}</div>;
                                            }
                                        }
                                    }
                                </Request>
                            </th>
                        </tc>
                        <tc className={"App-body"}>
                            <th>Title
                                <Request
                                    url='/books/titles'
                                    method='get'
                                    accept='application/json'
                                    verbose={true}>
                                    {
                                        ({error, result, loading}) => {
                                            if (loading) {
                                                return <div>loading...</div>;
                                            } else {
                                                return <div>{JSON.stringify(result.body)}</div>;
                                            }
                                        }
                                    }
                                </Request>
                            </th>
                        </tc>
                        <tc className={"App-body"}>
                            <th>ISBN
                                <Request
                                    url='/books/isbn'
                                    method='get'
                                    accept='application/json'
                                    verbose={true}>
                                    {
                                        ({error, result, loading}) => {
                                            if (loading) {
                                                return <div>loading...</div>;
                                            } else {
                                                return <div>{JSON.stringify(result.body)}</div>;
                                            }
                                        }
                                    }
                                </Request>
                            </th>
                        </tc>
                        </thead>
                    </Table>
                </header>
            </div>
        );
    }
}

export default App;