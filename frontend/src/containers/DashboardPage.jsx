import React from 'react';
import {connect} from 'react-redux';
import {withRouter} from 'react-router';
// import PropTypes from 'prop-types';
import Dashboard from '../components/Dashboard/Dashboard';
import PropTypes from "prop-types";

class DashboardPage extends React.Component {
    render() {
        return (
            <Dashboard history={this.props.history}/>
        );
    }
}

DashboardPage.propTypes = {
    history: PropTypes.shape({
        push: PropTypes.func.isRequired,
    }).isRequired,
};

const mapStateToProps = () => ({});

const mapDispatchToProps = {};

export default withRouter(connect(
    mapStateToProps,
    mapDispatchToProps
)(DashboardPage));
