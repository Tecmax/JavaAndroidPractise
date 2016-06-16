<%
            String admin = request.getParameter("admin");
            String psw = request.getParameter("psw");
            org.hibernate.SessionFactory sf = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            org.hibernate.Session s = sf.openSession();
            org.hibernate.Transaction tr = s.beginTransaction();
            kb.Admin ka = new kb.Admin();
            org.hibernate.Query q = s.createQuery("From Admin where loginid='" + admin + "'");
            //q.setParameter("a", admin);
            java.util.ArrayList al = new java.util.ArrayList();
            al = (java.util.ArrayList) q.list();
            java.util.Iterator it = al.iterator();
            if (it.hasNext()) {
              ka=(kb.Admin)it.next();
                String pswd = ka.getPassword();
                session.setAttribute("suid", admin);
                        
                if (pswd.equals(psw)) {
                    String ad = ka.getName();
                    //session.setAttribute("admn", ad);
                    response.sendRedirect("adminhome.jsp");
                } else {
                    response.sendRedirect("admin.jsp?msg=<font color='red' size=4>check the password</font>");
                    

                }

            }else
                               {
                 response.sendRedirect("admin.jsp?msg1=<font color='red' size=4>Wrong Id</font>");
                    

            }


        %>

