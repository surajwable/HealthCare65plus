
import { useEffect, useState } from 'react';
import { NavLink as ReactLink, useNavigate } from 'react-router-dom';
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,

} from 'reactstrap';
import { doLogOut, getCurruntUserDetails, isLoggedIn } from "../Auth"
const CustomNavbar = () => {

  const navigate=useNavigate()
  const [isOpen, setIsOpen] = useState(false)

  const [login, setLogin] = useState(false)
  const [user, setUser] = useState(undefined)

  //life cycle method rendaring
  useEffect(() => {

    setLogin(isLoggedIn())
    setUser(getCurruntUserDetails())

  }, [login])

  //for logout

  const logout=()=>{
    doLogOut(()=>{
      setLogin(false)
      navigate("/")
    })
  }
  return (
    <div>
      <Navbar
        color="dark"
        dark
        expand="md"
        fixed=""
        className='px-3'
      >
        <NavbarBrand tag={ReactLink} to="/">EMP</NavbarBrand>
        <NavbarToggler onClick={() => setIsOpen(!isOpen)} />
        <Collapse isOpen={isOpen} navbar>

          <Nav className="me-auto" navbar>

            <NavItem>
              <NavLink tag={ReactLink} to="/">
                Home
              </NavLink>
            </NavItem>

            <NavItem>
              <NavLink tag={ReactLink} to="/about">
                AboutUs
              </NavLink>
            </NavItem>

            <NavItem>
              <NavLink tag={ReactLink} to="/services">
                Services
              </NavLink>
            </NavItem>

            <NavItem>
              <NavLink tag={ReactLink} to="/contactus">
                ContactUs
              </NavLink>
            </NavItem>

          </Nav>

          <Nav navbar>

            {

              login && (
                <>
                <NavItem>
                    <NavLink tag={ReactLink} to="/users/profileinfo">
                      profileInfo
                    </NavLink>
                  </NavItem>

                  <NavItem>
                    <NavLink onClick={logout}>
                      logout
                    </NavLink>
                  </NavItem>

                  <NavItem>
                    <NavLink tag={ReactLink} to="/users/user">
                      {user.email}
                    </NavLink>
                  </NavItem>
                </>
              )
            }

            {
              !login && (
                <>
                  <NavItem>
                    <NavLink tag={ReactLink} to="/login">
                      SignIn
                    </NavLink>
                  </NavItem>

                  <NavItem>
                    <NavLink tag={ReactLink} to="/register">
                      SignUp
                    </NavLink>
                  </NavItem>
                </>
              )
            }
          </Nav>

        </Collapse>
      </Navbar>
    </div>
  );
}
export default CustomNavbar;