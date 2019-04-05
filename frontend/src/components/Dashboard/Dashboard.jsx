import React from 'react';
import {connect} from 'react-redux';
import PropTypes from "prop-types";
// import PropTypes from 'prop-types';
// import {makeAction} from '../redux/actions/makeAction';
// import {auth} from '../redux/actions/actionTypes';
import {BOOKS_PAGE} from "../../configuration/paths";

class Dashboard extends React.Component {
    // The constructor for a React component is called before it is mounted
    // The constructor is the right place to initialize state
    constructor(props) {
        super(props);
        this.state = {
            clicked: false,
        };
        this.handleClick = this.handleClick.bind(this);
    }
    handleClick() {
        this.props.history.push(BOOKS_PAGE);
    }
    render() {
        return (
            <div className="dashboard">
                <h1 className="dashboard-title">Wellcome to React-Redux-Saga boilerplate!</h1>
                <h2>It's based on create-react-app enhanced with:</h2>
                <ul className="dashboard-list">
                    <li>- containers examples</li>
                    <li>- components examples</li>
                    <li>- router routes examples</li>
                    <li>- routes guardians</li>
                    <li>- input validators</li>
                    <li>- asynchronous calls with saga examples</li>
                    <li>- rootReducer, rootSaga examples</li>
                    <li>- ready requests library based on axios</li>
                    <li>- translation from counterpart</li>
                    <li>- jQuery added to WebPack configuration with global access</li>
                    <li>- bootstrap and font awesome (if you want to activate bootstrap go to main index.jsc and uncomment it)</li>
                </ul>
                <button onClick={this.handleClick}>Books</button>
            </div>
        );
    }
}

Dashboard.propTypes = {
    history: PropTypes.shape({
        push: PropTypes.func.isRequired,
    }).isRequired,
};

const mapStateToProps = () => ({});

const mapDispatchToProps = {};

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(Dashboard);
