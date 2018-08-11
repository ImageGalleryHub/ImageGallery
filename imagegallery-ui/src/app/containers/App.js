import React from 'react';
import { connect } from 'react-redux';
import AppBar from '@material-ui/core/AppBar';
import MuiThemeProvider from '@material-ui/core/styles/MuiThemeProvider';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';

import { setName } from '../actions/userActions';
import Login from '../components/login/Login';

class App extends React.Component {
  render() {
    return (
      <MuiThemeProvider>
        <AppBar position="static" title="Image Gallery">
          <Toolbar>
            <Typography variant="title" color="inherit">
              Image Gallery Login
            </Typography>
          </Toolbar>
          {/* <Main changeUsername={() => this.props.setName("Anna")}/>
                <User username={this.props.user.name}/> */}
        </AppBar>
        <Login />
        {/* <MyForm /> */}
      </MuiThemeProvider>
    );
  }
}

const mapStateToProps = state => {
  return {
    user: state.user,
    math: state.math
  };
};

const mapDispatchToProps = dispatch => {
  return {
    setName: name => {
      dispatch(setName(name));
    }
  };
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(App);
