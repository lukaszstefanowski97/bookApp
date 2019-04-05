import React from 'react';
import './books.css';
import PropTypes from 'prop-types';
import {connect} from 'react-redux';
import {withRouter} from 'react-router';
import {makeAction} from "../../redux/actions/makeAction";
import {books} from "../../redux/actions/actionTypes";
import {BOOKS_PAGE} from "../../configuration/paths";

const Books = ({getBooksAction, history, books, addBookAction}) => {
    const callback = () => history.push(BOOKS_PAGE);

    return (
        <React.Fragment>
            <div className="divTable">
                <div className="divTableHeading">
                    <div className="divTableHead">1</div>
                    <div className="divTableHead">2</div>
                    <div className="divTableHead">3</div>
                </div>
                <div className="divTableBody">
                    {books ?
                        books.map((book, index) =>
                            <div key={index} className="divTableRow">
                                <div className="divTableCell">{book.title}</div>
                                <div className="divTableCell">&nbsp;</div>
                                <div className="divTableCell">&nbsp;</div>
                            </div>
                        )
                        :
                        <div>NIE MA</div>
                    }
                </div>
            </div>
            <button onClick={() => addBookAction(
                {
                    data: {
                        author: 'Adam Adam',
                        title: 'siema',
                        isbn: '1234567898765'
                    },
                    callback: callback,
                })}>DODAJ</button>
        </React.Fragment>
    )
};

Books.propTypes = {
    books: PropTypes.array,
    history: PropTypes.shape({
        push: PropTypes.func.isRequired,
    }).isRequired,
};

const mapStateToProps = () => ({});

const mapDispatchToProps = {
    addBookAction: makeAction(books.ADD_BOOK),
};

export default withRouter(connect(
    mapStateToProps,
    mapDispatchToProps
)(Books));
